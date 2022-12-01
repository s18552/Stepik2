import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class FriendshipsAssertJTest {
    private Friendships friendships;

    @BeforeEach
    public void setup(){
        friendships= new Friendships();

    }

    @Test
    public void createInstance() {
        assertThat(friendships.getClass()).isEqualTo(Friendships.class);
    }

    @Test
    public void checkIfAreFriendsTest(){
        //given
        String person1="Bartek";
        String person2="Rafał";

        //when
        friendships.makeFriends("Bartek", "Rafał");

        //then
        assertThat(friendships.areFriends(person1,person2)).isTrue();

    }

    @Test
    public void checkIfAreFriendsOtherTest(){
        //given
        String person1="Bartek23";
        String person2="rafal";

        //when
        friendships.makeFriends(person1, person2);

        //then
        assertThat(friendships.areFriends(person1,person2)).isTrue();

    }

    @Test
    public void checkIfAreNotFriendsTest(){
        //given
        String person1="Bartek";
        String person2="Tomasz";

        //then
        assertThat(friendships.areFriends(person1,person2)).isFalse();

    }

    @Test
    public void checkListFriendshipsTest(){
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
        assertThat(friendships.getFriendsList(person1))
                .hasSize(3)
                .contains(person2,person3,person4);


    }
    @Test
    public void checkThrowsExceptionTest(){
        assertThatThrownBy(() -> friendships.getFriendsList(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    public void checkIfListHasLeszekAndIsFirstFriend() {
        //given
        String name1="Andrzej";
        String name2="Jan";
        String name3="Leszek";

        //when
        friendships.makeFriends(name1,name3);
        friendships.makeFriends(name1,name2);

        //then
        FriendshipsAssert.assertThat(friendships)
                .hasFriendWithNameLeszek(name1)
                .checkIfFriendIsOnFirstPosition(name1, name3);
    }

    @Test
    public void checkIfListHasntLeszekAndIsFirstFriend() {
        //given
        String name1="Andrzej";
        String name2="Jan";
        String name3="Leszek1";

        //when
        friendships.makeFriends(name1,name3);
        friendships.makeFriends(name1,name2);

        //then
        assertThatThrownBy(()->FriendshipsAssert.assertThat(friendships)
                .hasFriendWithNameLeszek(name1)
                .checkIfFriendIsOnFirstPosition(name1, name3))
                .hasMessageStartingWith("Expected Leszek from");

    }

    @AfterEach
    public void tearDown(){
        friendships= null;
    }



}