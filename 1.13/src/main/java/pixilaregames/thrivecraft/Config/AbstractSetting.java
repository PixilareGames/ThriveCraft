package pixilaregames.thrivecraft.Config;

public abstract class AbstractSetting
{
    String comment;
    String category;
    String name;

    private final char type;

    public AbstractSetting(char type) {
        this.type = type;
    }

    char getType() {
        return type;
    }

    abstract Object getValue();
}
