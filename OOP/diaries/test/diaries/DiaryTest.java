package diaries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    Diary diary = new Diary("Adah02", "trey5");

    @Test
    public void diaryIsLockedTest(){
        diary.lockDiary();
        assertTrue(diary.isLocked());

        diary.unlockDiary("trey4");
        assertTrue(diary.isLocked());
    }

    @Test
    public void diaryIsUnlockedTest(){
        diary.unlockDiary("trey5");
        assertFalse(diary.isLocked());
    }

    @Test
    public void entryIsEmptyTest(){
        assertTrue(diary.entryIsEmpty());
    }

    @Test
    public void entryIsNotEmptyTest(){
        diary.createEntry(1704, "Adah02", "trey5");
        assertFalse(diary.entryIsEmpty());
    }

    @Test
    public void deleteEntryTest(){
        diary.createEntry(1704, "Adah02", "trey5");

        diary.deleteEntry(1704);
        assertTrue(diary.entryIsEmpty());
    }

    @Test
    public void deleteEntryExceptionTest(){
        diary.createEntry(17, "Adah02", "trey5");
        assertThrows(IdentityMismatchException.class, () -> diary.deleteEntry(175));
    }

    @Test
    public void findEntryByUserIdTest(){
        diary.createEntry(17, "Adah02", "trey5");
        assertEquals(String.format("ID: %d%n, Title: %s%n, Body: %s%n", 17, "Adah02", "trey5"),
                diary.findEntryByUserId(17).toString());
    }
}