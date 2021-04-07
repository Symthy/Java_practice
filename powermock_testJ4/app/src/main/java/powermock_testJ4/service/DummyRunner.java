package powermock_testJ4.service;

import powermock_testJ4.arg.IArgument;

public class DummyRunner {
  private IArgument arg;

  public DummyRunner(IArgument arg) {
    this.arg = arg;
  }

  public String run() {
    System.out.println("dummy run: " + arg.output());

    return "Success: " + arg.output();
  }
}
