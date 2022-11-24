import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Friendships {
    Map<String, List<String>> friendships = new HashMap<>();

    //Dodanie przyjaciół - wykorzystuje funkcje addFriend!
    public void makeFriends(String person1, String person2) {
        addFriend(person1, person2);
        addFriend(person2, person1);
    }

    //Pobranie listy przyjaciol
    public List<String> getFriendsList(String person) {
        List<String> friends = friendships.get(person);
        if (friends == null) throw new NullPointerException();
        return friends;
    }

    //Sprawdzenie czy przyjaciele
    public boolean areFriends(String person1, String person2) {
        try {
            return getFriendsList(person1).contains(person2);
        } catch (NullPointerException ex) {
            return false;
        }
    }

    //Dodanie do listy przyjaciol do danej osoby
    private void addFriend(String person, String friend) {
        List<String> friends;
        try {
            friends = getFriendsList(person);
        } catch (NullPointerException ex) {
            friends = new ArrayList<>();
        }
        friends.add(friend);
        friendships.put(person, friends);

    }
}