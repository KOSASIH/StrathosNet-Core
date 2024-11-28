package core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StrathosNetApplication {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        System.out.println("Starting StrathosNet Application...");
        NetworkManager networkManager = new NetworkManager();
        executorService.submit(networkManager::initializeNetwork);
    }
}
