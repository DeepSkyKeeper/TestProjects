package dsk.redone.view;
import dsk.redone.repository.DataRepo;

public class ConsoleView implements UserView {

    @Override
    public void dataOut() {
       DataRepo.getErList().forEach(System.out::println);
    }
}
