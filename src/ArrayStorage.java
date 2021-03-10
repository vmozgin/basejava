/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int storageSize = 0;
    private boolean success = false;

    private void resumeNotFound() {
        System.out.println("Такого резюме нет");
    }

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    void save(Resume r) {
        if (storageSize < storage.length) {
            storage[storageSize] = r;
            storageSize++;
        }
    }

    void update(Resume r) {
        for (int i = 0; i < storageSize; i ++) {
            if (storage[i].equals(r)) {
                storage[i] = r;
                success = true;
            }
        }

        if (success = false) {
            resumeNotFound();
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        resumeNotFound();
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                for (int j = i; j < storageSize - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storageSize--;
                success = true;
                break;
            }
        }

        if (success = false) {
            resumeNotFound();
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeWithoutNulls = new Resume[storageSize];
        for (int i = 0; i < storageSize; i++) {
            resumeWithoutNulls[i] = storage[i];
        }
        return resumeWithoutNulls;
    }

    int size() {
        return storageSize;
    }
}
