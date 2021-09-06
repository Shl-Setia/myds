import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> sterling = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sterling " + Thread.currentThread().getName());
            return "Sterling";
        });


        CompletableFuture<String> oneLP = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("OneLP " + Thread.currentThread().getName());
            return "OneLP";
        });

        CompletableFuture<String> svs = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * 1);
                throw new Exception("ss");
            } catch (InterruptedException e) {
                //e.printStackTrace();
            } catch (Exception e) {
                //e.printStackTrace();
                return "SVS Exception";
            }
            System.out.println("SVS " + Thread.currentThread().getName());
            return "SVS";
        });


        //CompletableFuture.allOf(sterling,oneLP,svs).thenAccept(v -> System.out.println("done"));



        CompletableFuture<List<String>> allResult = CompletableFuture.allOf(sterling, oneLP, svs)
                .thenApply(v -> {
                    System.out.println("all done " + Thread.currentThread().getName());
                    return Stream.of(sterling, oneLP, svs)
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());
        });

        try {
            List<String> list = allResult.get(8, TimeUnit.SECONDS);
            System.out.println(list + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
