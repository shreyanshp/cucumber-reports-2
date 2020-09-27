package io.github.shreyanshp.cucumber.reporting.types.breakdown;

public class BreakdownStats {
    private int passed;
    private int failed;
    private int skipped;
    public BreakdownStats() {
        this.passed = 0;
        this.failed = 0;
        this.skipped = 0;
    }
    public int getPassed() {
        return passed;
    }
    public int getFailed() {
        return failed;
    }
    public int getSkipped() {
        return skipped;
    }
    public void addPassed() {
        this.passed++;
    }
    public void addFailed() {
        this.failed++;
    }
    public void addSkipped() {
        this.skipped++;
    }
    public void addPassed(int value) {
        this.passed += value;
    }
    public void addFailed(int value) {
        this.failed += value;
    }
    public void addSkipped(int value) {
        this.skipped += value;
    }
    public BreakdownStats add(BreakdownStats another) {
        this.passed += another.getPassed();
        this.failed += another.getFailed();
        this.skipped += another.getSkipped();
        return this;
    }
}
