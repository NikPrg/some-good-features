package com.example.demo.vicRent.testForRepository;

import com.example.demo.vicRent.testForGetAllUsersMethod.repo.UserRepo;
import lombok.SneakyThrows;
import org.jooq.lambda.Unchecked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public interface OrderRepo extends JpaRepository<Order, Long> {
    Stream<Order> findByActiveTrue();
}

class Executor {
    public static void main(String[] args) {
        Exporter exporter = new Exporter();

        OrderExportFile orderExFile = new OrderExportFile();
        exporter.exportFile("test", orderExFile::writeContent);

        UserExportFile userExportFile = new UserExportFile();
        exporter.exportFile("test", userExportFile::writeContent);
    }
}


class Exporter {

    public File exportFile(String fileName, Consumer<Writer> writerConsumer) {
        File file = new File("export/" + fileName);
        try (Writer writer = new FileWriter(fileName)) {
            writerConsumer.accept(writer);
            return file;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

class OrderExportFile {
    private OrderRepo orderRepo;
    @SneakyThrows
    protected void writeContent(Writer writer) {
        writer.write("ID;Date\n");
        orderRepo.findByActiveTrue()
                .map(order -> order.id() + ";" + order.creationalDate())
                .forEach(Unchecked.consumer(writer::write));
    }
}

class UserExportFile {
    private UserRepo userRepo;
    @SneakyThrows
    protected void writeContent(Writer writer) {
        writer.write("username\n");
        userRepo.findAll()
                .stream().map(user -> user.getFirstName() + ";")
                .forEach(Unchecked.consumer(writer::write));
    }
}

record Order(boolean active, Long id, String creationalDate) {
}
