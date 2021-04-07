package powermock_testJ4.arg;

public class ArgumentTwo implements IArgument {
  private String str;

  public ArgumentTwo(String str) {
    this.str = str;
  }

  public String output() {
    return this.str;
  }
}
