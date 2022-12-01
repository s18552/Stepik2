import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class ListSmallerThan13 extends TypeSafeMatcher<List<String>> {

    @Override
    public void describeTo(Description description) {
        description.appendText("List size has to be smaller than 13");
    }

    @Override
    protected boolean matchesSafely(List<String> item) {
        return item.size()<13;
    }
    public static Matcher<List<String>> listSizeIsSmallerThan13() {
        return new ListSmallerThan13();
    }
}
