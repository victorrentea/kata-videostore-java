package videostore.horror;

import lombok.Getter;

@Getter
public enum Category {
    REGULAR(0),
    NEW_RELEASE(1),
    CHILDRENS(2);

    private final int value;

    Category(int value) {
        this.value = value;
    }

}