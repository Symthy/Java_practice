package powermock_testJ4.service;

import powermock_testJ4.arg.ArgumentOne;
import powermock_testJ4.arg.IArgument;

public class Service {
  // private DummyRunner runner;

  // public Service(DummyRunner runner) {
  //   this.runner = runner;
  // }

  public String execute() {
    IArgument arg = new ArgumentOne("arg 1");
    DummyRunner runner = new DummyRunner(arg);
    return runner.run();
  }
}
