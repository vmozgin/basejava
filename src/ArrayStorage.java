
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length - 1; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
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
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    break;
                }
            }
        }
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumeWithoutNulls = new Resume[size()];
        for (int i = 0; i < storage.length - 1; i++) {
            if (storage[i] != null) {
                resumeWithoutNulls[i] = storage[i];
            }
        }
        return resumeWithoutNulls;
    }

    int size() {
        int size = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                size++;
            }
        }
        return size;
    }
}
