package ru.job4j.tracker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
   @Test
    public void  whenDeleteItemThenReturnNewArrayWithoutItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription1");
        Item item2 = new Item("test2", "testDescription2" );
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item2.getId());
        assertThat(tracker.findAll(), is(Arrays.asList(item1)));
    }

    @Test
    public void  whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item item = new Item("name","test1", 123L);
        tracker.add(item);
        Item newItem = new Item("newname", "test2", 323L);
        newItem.setId(item.getId());
        tracker.replace(item.getId(), newItem);
        assertThat(tracker.findById(item.getId()).getName(), is("newname"));
    }
    @Test
    public void whenFindByIdThenReturnCorrectItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "name1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "name2", 345L);
        tracker.add(item2);
        Item result = tracker.findAll().get(0);
        result.setId(tracker.findAll().get(0).getId());
        assertThat(tracker.findAll().get(0), is(result));
    }
    @Test
    public void whenFindByNameThenReturnItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "name1", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "name2", 345L);
        tracker.add(item2);
        List<Item> result = tracker.findByName("name2");
        assertThat(tracker.findByName("name2"), is(result));
    }
}