
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int storageSize = 0;

    void clear() {
        for (int i = 0; i < storage.length - 1; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
        storageSize++;
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    return resume;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
        }
        for (int i = 0; i < storageSize; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
        storageSize--;
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
