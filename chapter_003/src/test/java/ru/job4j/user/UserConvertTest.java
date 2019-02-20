package ru.job4j.user;

import org.junit.Test;
import ru.job4j.list.ConvertList2Array;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    /**
     * @author tumen.garmazhapov
     * @since 02.2019
     */
public class UserConvertTest {
        @Test
        public void whenList3UserConvertHashMap() {
            UserConvert userConvert = new UserConvert();
            User user1 = new User(7,"Cristiano Ronaldo", "Torino");
            User user2 = new User(5, "Donald Trump", "Washington");
            User user3 = new User(1, "Jackie Chan", "Shanghai");
            List<User> list = new ArrayList<>();
            list.add(user1);
            list.add(user2);
            list.add(user3);
            HashMap<Integer, User> result = userConvert.process(list);
            HashMap expect = new HashMap();
            expect.put(user1.getId(), user1);
            expect.put(user2.getId(), user2);
            expect.put(user3.getId(), user3);
            assertThat(result, is(expect));
        }

        @Test
        public void whenList3UserConvertInHashMapAndFindById() {
            UserConvert userConvert = new UserConvert();
            User user1 = new User(7,"Cristiano Ronaldo", "Torino");
            User user2 = new User(5, "Donald Trump", "Washington");
            User user3 = new User(1, "Jackie Chan", "Shanghai");
            List<User> list = new ArrayList<>();
            list.add(user1);
            list.add(user2);
            list.add(user3);
            HashMap<Integer, User> result = userConvert.process(list);
            assertThat(result.get(5).getName(),  is("Donald Trump"));
        }
}
