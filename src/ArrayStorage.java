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

    public void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }
        storageSize = 0;
    }

    public void save(Resume r) {
        if (getIndex(r.uuid) != - 1) {
            System.out.println("Resume " + r.uuid + " already exist");
        } else if (storageSize == storage.length){
            System.out.println("Storage overflow");
        } else {
            storage[storageSize] = r;
            storageSize++;
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.uuid);
        if (index == - 1) {
            System.out.println("Resume " + r.uuid + " not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == - 1) {
            System.out.println("Resume " + uuid + " not exist");
            return  null;
        }
        return storage[index];
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == - 1) {
            System.out.println("Resume " + uuid + " not exist");
        }else {
            storage[index] = storage[storageSize - 1];
            storage[storageSize - 1] = null;
            storageSize--;
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

    public int size() {
        return storageSize;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
