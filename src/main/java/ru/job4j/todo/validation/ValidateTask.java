package ru.job4j.todo.validation;

import ru.job4j.todo.model.Task;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ValidateTask {

    public static void checkOptional(Optional<Task> result, HttpServletResponse response) throws IOException {
        if (result.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public static void updateDeleteComplete(HttpServletResponse response, boolean result) throws IOException {
        if (!result) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}