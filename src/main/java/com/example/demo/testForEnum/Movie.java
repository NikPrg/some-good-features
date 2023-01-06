package com.example.demo.testForEnum;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class Executor{
    public static void main(String[] args) {

        NewReleasePriceRepo repo = mock(NewReleasePriceRepo.class);
        when(repo.getFactor()).thenReturn(2);

        PriceService priceService = new PriceService(repo);
        System.out.println(priceService.computePrice(Movie.Type.REGULAR, 2));
        System.out.println(priceService.computePrice(Movie.Type.CHILDREN, 2));
        System.out.println(priceService.computePrice(Movie.Type.NEW_RELEASE, 2));
    }
}

public class Movie {
    enum Type {
        REGULAR(PriceService::computeRegularPrice),
        NEW_RELEASE(PriceService::computeNewReleasePrice),
        CHILDREN(PriceService::computeChildrenPrice);

        public final BiFunction<PriceService, Integer, Integer> priceAlgo;

        Type(BiFunction<PriceService, Integer, Integer> priceAlgo) {
            this.priceAlgo = priceAlgo;
        }
    }
    private final Type type;

    public Movie(Type type) {
        this.type = type;
    }

}
interface NewReleasePriceRepo {
    int getFactor();
}
@Service
@RequiredArgsConstructor
class PriceService {
    private final NewReleasePriceRepo repo;

    int computeNewReleasePrice(int days) {
        return days * repo.getFactor();
    }

    int computeRegularPrice(int days) {
        return days + 1;
    }

    int computeChildrenPrice(int days) {
        return 5;
    }

    public int computePrice(Movie.Type type, int days){
        return type.priceAlgo.apply(this, days);
    }
}
