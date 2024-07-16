package io.cristianmeneses.ocjp.lesson4.flowControl;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class SwitchStatements {

    public static void main(String[] args) {
        log.info("Lesson 4 - Switch statements.");
        SwitchStatements s = new SwitchStatements();
        s.fallThrough();
        s.multiCase();
        s.arrowSwitch();
        s.arrowMultiCase();
        s.switchExpressions();
        s.switchComplexExpressions();
        log.info("Lesson 4 - All done.");
    }

    /**
     * Remember to close your <code>case</code> statements with a <code>break</code>!
     */
    public void fallThrough() {
        Set<Integer> nums = Set.of(1, 2, 0);
        for (int n: nums) {
            switch (n) {
                case 0:
                    log.info("{} -> It's a zero", n);
                case 1:
                    log.info("{} -> It's less than 2", n);
                    break;
                default:
                    log.info("{} -> Seems like 2", n);
                    break;
            }
        }
    }

    public void multiCase() {
        Set<Integer> nums = Set.of(1, 2, 0);
        for (int n: nums) {
            switch (n) {
                case 0:
                case 1:
                    log.info("{} -> It's less than 2", n);
                    break;
                default:
                    log.info("{} -> Seems like 2", n);
                    break;
            }
        }
    }

    public void arrowSwitch() {
        Set<Integer> nums = Set.of(1, 2, 0);
        for (int n: nums) {
            switch (n) {
                case 0 ->
                    log.info("{} -> It's a zero", n);
                case 1 ->
                    log.info("{} -> It's less than 2", n);
                default ->
                    log.info("{} -> Seems like 2", n);
            }
        }
    }

    public void arrowMultiCase() {
        Set<Integer> nums = Set.of(1, 2, 0);
        for (int n: nums) {
            switch (n) {
                case 0, 1 ->
                    log.info("{} -> It's less than 2", n);
                default ->
                    log.info("{} -> Seems like 2", n);
            }
        }
    }

    public void switchExpressions() {

        int x = (int)(Math.random() * 3);
        var res = switch (x) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 100 -> throw new IllegalArgumentException("Too large");
            default -> String.valueOf(x);
        };
        log.info("Got {}", res);
    }

    public void switchComplexExpressions() {

        int x = (int) (Math.random() * 3);
        var res = switch (x) {
            case 0 -> {
                // yield is not a keyword!
                int yield = 0;
                log.info("We;ve got ourselves a {}}!", yield);
                yield "Zero";
            }
            case 1 -> "One"; // can't use yield on a non-block form
            case 100 -> throw new IllegalArgumentException("Too large");
            default -> String.valueOf(x);
        };
        log.info("Got {}", res);
    }
}
