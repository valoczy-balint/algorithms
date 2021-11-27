package sort;

import java.util.List;

public interface Sort {
    public <T extends Comparable> List<T> sort(List<T> input);
}
