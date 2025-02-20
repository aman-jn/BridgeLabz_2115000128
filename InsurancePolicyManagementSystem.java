import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Policy policy = (Policy) obj;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + coverageType + " - " + premiumAmount + " - " + expiryDate;
    }
}

public class InsurancePolicyManagementSystem {

    public static void storePolicies(Set<Policy> set, List<Policy> policies) {
        set.addAll(policies);
    }

    public static void displayPolicies(Set<Policy> set) {
        for (Policy policy : set) {
            System.out.println(policy);
        }
    }

    public static void displayExpiringSoon(Set<Policy> set) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date thresholdDate = calendar.getTime();

        for (Policy policy : set) {
            if (!policy.getExpiryDate().after(thresholdDate)) {
                System.out.println(policy);
            }
        }
    }

    public static void displayByCoverageType(Set<Policy> set, String coverageType) {
        for (Policy policy : set) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public static void findDuplicatePolicies(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println("Duplicate policy found: " + policy);
            }
        }
    }

    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.set(2024, Calendar.MARCH, 10);
        policies.add(new Policy("P001", "Alice", cal.getTime(), "Health", 500.0));

        cal.set(2024, Calendar.FEBRUARY, 25);
        policies.add(new Policy("P002", "Bob", cal.getTime(), "Auto", 700.0));

        cal.set(2024, Calendar.APRIL, 15);
        policies.add(new Policy("P003", "Charlie", cal.getTime(), "Home", 300.0));

        cal.set(2024, Calendar.FEBRUARY, 25);
        policies.add(new Policy("P002", "Bob", cal.getTime(), "Auto", 700.0));

        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>();

        storePolicies(hashSet, policies);
        storePolicies(linkedHashSet, policies);
        storePolicies(treeSet, policies);

        System.out.println("HashSet (Quick Lookup):");
        displayPolicies(hashSet);

        System.out.println("\nLinkedHashSet (Insertion Order):");
        displayPolicies(linkedHashSet);

        System.out.println("\nTreeSet (Sorted by Expiry Date):");
        displayPolicies(treeSet);

        System.out.println("\nPolicies Expiring Soon:");
        displayExpiringSoon(treeSet);

        System.out.println("\nPolicies with Coverage Type 'Auto':");
        displayByCoverageType(treeSet, "Auto");

        System.out.println("\nChecking for Duplicate Policies:");
        findDuplicatePolicies(policies);

        long start, end;
        start = System.nanoTime();
        hashSet.contains(new Policy("P001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(new Policy("P001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(new Policy("P001", "", new Date(), "", 0));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");
    }
}
