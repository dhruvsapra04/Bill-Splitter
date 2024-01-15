public class BillSplitter {

    public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target) {
        // Call Iterator method to get the list
        CopyableIterator<Integer> remainingList = in.iterator();
        // Call private static method and return the solution
        UniqueOrderedList<Integer> solution = splitOurBill(remainingList, target);

        return solution;

    }

    private static UniqueOrderedList<Integer> splitOurBill(CopyableIterator<Integer> it, int target) {

        // check if there is any items remaining
        if (!it.hasNext()) {
            // Check Target
            if (target == 0) {
                UniqueOrderedList<Integer> emptyList = new UniqueOrderedList<Integer>();
                // System.out.println("return empty list");
                // return empty list
                return emptyList;
            } else {
                // if target is not 0
                // System.out.println("return null");
                return null;
            }
        } else {
            // Read the value from iteration
            Integer curr = it.next();

            // Create instance of UniqueOrderedList<Integer> for passing the solution
            UniqueOrderedList<Integer> soln = new UniqueOrderedList<>();

            // check if current is less than or equal to target
            if (curr <= target) {
                // get iteratore as separate copy to pass to recursion
                CopyableIterator<Integer> copiedIteraorTargetGreater = it.copy();

                // Recursive call

                soln = splitOurBill(copiedIteraorTargetGreater, target - curr);

                // CHeck if curr contain in soln if yes then add it

                if (soln != null && soln.contains(curr)) {

                    // Add to solution
                    soln.add(curr);

                    return soln;
                } else if (soln != null && !soln.contains(curr)) {
                    // Add to solution the current value
                    soln.add(curr);
                    return soln;
                }
            }
            // get iteratore as separate copy to pass to recursion
            CopyableIterator<Integer> copiedIteraorTargetLess = it.copy();
            // Recursive call
            soln = splitOurBill(copiedIteraorTargetLess, target);

            // return solution
            return soln;

        }

    }
}
