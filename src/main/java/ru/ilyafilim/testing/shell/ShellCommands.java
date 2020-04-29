package ru.ilyafilim.testing.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.ilyafilim.testing.services.GameService;

@ShellComponent
public class ShellCommands {

    final GameService gameService;

    public ShellCommands(GameService game) {
        this.gameService = game;
    }

    @ShellMethod(key = "testing", value = "Start the animal test (Russian)")
    public void startTest() {
        gameService.game();
    }
}
