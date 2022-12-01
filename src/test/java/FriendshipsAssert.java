import org.assertj.core.api.AbstractAssert;

public class FriendshipsAssert extends AbstractAssert<FriendshipsAssert, Friendships> {
    protected FriendshipsAssert(Friendships actual) {
        super(actual, FriendshipsAssert.class);
    }

    public static FriendshipsAssert assertThat(Friendships actual) {
        return new FriendshipsAssert(actual);
    }

    public FriendshipsAssert hasFriendWithNameLeszek(String name){
        isNotNull();
        if(!actual.getFriendsList(name).contains("Leszek")){
            failWithMessage("Expected Leszek from friends %s but was %s",
                    name, actual.getFriendsList(name));
        }

        return this;
    }

    public FriendshipsAssert checkIfFriendIsOnFirstPosition(String name, String nameOfFriend){
        isNotNull();
        if(!actual.getFriendsList(name).get(0).equals(nameOfFriend)){
            failWithMessage("Expected %s on first position but was %s",
                    name, actual.getFriendsList(name).get(0));
        }

        return this;
    }
}
