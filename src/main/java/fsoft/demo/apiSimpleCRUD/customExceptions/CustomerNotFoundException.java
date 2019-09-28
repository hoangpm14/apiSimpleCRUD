package fsoft.demo.apiSimpleCRUD.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException
{
    private Long id;

    public CustomerNotFoundException(Long id)
    {
        super((String.format("Customer '" + id + "' is not found")));
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
}
