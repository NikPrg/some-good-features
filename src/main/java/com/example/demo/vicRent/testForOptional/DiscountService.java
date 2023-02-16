package com.example.demo.vicRent.testForOptional;

import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.*;

@Service
public class DiscountService {

    public static void main(String[] args) {


        DiscountService discountService = new DiscountService();
        String discountLine = discountService.getDiscountLine(new Customer(new MemberCard(10)));
        System.out.println(discountLine);
    }

    public String getDiscountLine(Customer customer) {
        return customer.getMemberCard()
                .flatMap(card -> getDiscountPercentage(card))
                .map(integer -> "Discount%: " + integer)
                .orElse("No discount");
    }


    private Optional<Integer> getDiscountPercentage(MemberCard memberCard) {
        if (memberCard.points() >= 100) {
            return of(5);
        }
        if (memberCard.points() >= 50) {
            return of(3);
        }
        return empty();

    }

}


record Customer(MemberCard memberCard) {
    public Optional<MemberCard> getMemberCard() {
        return ofNullable(memberCard);
    }
}

record MemberCard(Integer points) {
}
