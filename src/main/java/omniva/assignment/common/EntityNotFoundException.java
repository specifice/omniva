package omniva.assignment.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(Class<?> type, String id) {
    super(MessageFormat.format("{0} not found [id: {1}]", type.getSimpleName(), id));
  }
}
