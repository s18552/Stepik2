import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class FriendshipsHamcrestTest {
    private Friendships friendships;

    @BeforeEach
    public void setup(){
        friendships= new Friendships();
    }

    @Test
    public void createInstance() {
        assertThat(friendships.getClass(), is(Friendships.class));
    }

    private static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }

    @Test
    public void checkIfAreFriendsTest(){
        //given
        String person1="Bartek";
        String person2="Rafał";

        //when
        friendships.makeFriends("Bartek", "Rafał");

        //then
        assertThat(friendships.areFriends(person1,person2), is(true));

    }

    @Test
    public void checkIfAreFriendsOtherTest(){
        //given
        String person1="Bartek23";
        String person2="rafal";

        //when
        friendships.makeFriends(person1, person2);

        //then
        assertThat(friendships.areFriends(person1,person2), equalTo(true));

    }

    @Test
    public void checkIfAreNotFriendsTest(){
        //given
        String person1="Bartek";
        String person2="Tomasz";

        //then
        assertThat(friendships.areFriends(person1,person2), equalTo(false));

    }

    @Test
    public void checkLengthListFriendshipsTest(){
        //given
        String person1="Bartek";
        String person2="Tomasz";
        String person3="Jan";
        String person4= "Klaudia";

        //when
        friendships.makeFriends(person1, person2);
        friendships.makeFriends(person1, person3);
        friendships.makeFriends(person1, person4);

        //then
        assertThat(friendships.getFriendsList(person1),hasSize(3));


    }
    @Test
    public void checkThrowsExceptionTest(){
        assertThat(exceptionOf(() -> friendships.getFriendsList(null)), isA(NullPointerException.class));
    }

    @Test
    public void checkIfListHasLeszekAndIsFirstFriend(){
        //given
        String person1="Bartek";
        String person2="Leszek";


        //when
        friendships.makeFriends(person1, person2);

        //then
        assertThat(friendships.getFriendsList(person1),
                HasLeszekInList.hasLeszekInList()
                );

    }

    @Test
    public void checkIfListIsSmallerThan13(){
        //given
        String person1="Bartek";
        String person2="Leszek";


        //when
        friendships.makeFriends(person1, person2);

        //then
        assertThat(friendships.getFriendsList(person1),
                ListSmallerThan13.listSizeIsSmallerThan13()
        );


    }



    @AfterEach
    public void tearDown(){
        friendships= null;
    }
}
