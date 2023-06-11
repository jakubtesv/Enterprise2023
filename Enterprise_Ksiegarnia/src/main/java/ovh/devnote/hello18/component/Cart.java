package ovh.devnote.hello18.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class Cart {
    private List<Integer> bookIds = new ArrayList<>();

    public void addBookId(Integer id) {
        bookIds.add(id);
    }

    public void deleteBookId(Integer id) {
        bookIds.remove(id);
    }

    public List<Integer> getBookIds() {
        return bookIds;
    }
}