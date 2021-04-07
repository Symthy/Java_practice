package powermock_testJ4.arg;

public class ArgumentOne implements IArgument {
  private String str;

  public ArgumentOne(String str) {
    this.str = str;
  }

  public String output() {
    return this.str;
  }
}
