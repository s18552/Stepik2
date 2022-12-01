import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class HasLeszekInList extends TypeSafeMatcher<List<String>> {

    @Override
    protected boolean matchesSafely(List<String> item) {
        return item.contains("Leszek");
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Leszek");
    }

    public static Matcher<List<String>> hasLeszekInList() {
        return new HasLeszekInList();
    }
}

