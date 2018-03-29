package challenges.Food2Door;

public class SupplyProcessor {
    private Supplier supplier;
    private SupplyService supplyService;

    public SupplyProcessor(final Supplier supplier, final SupplyService supplyService) {
        this.supplier = supplier;
        this.supplyService = supplyService;
    }

    public void processSupply(final SupplyRequest supplyRequest) {
        boolean isRequested = supplyService.supply(supplyRequest.getSupplierName(),
                supplyRequest.getProductName(), supplyRequest.getProductQuantity());
        if (isRequested) {
            System.out.println("Initiating the supply request. \nSupplier name: " + supplyRequest.getSupplierName()
                    + "\nProduct name: " + supplyRequest.getProductName() + "\nQuantity: "
                    + supplyRequest.getProductQuantity() + "\n");
        } else {
            System.out.println("Supply request failed - please try again."
                    + supplyRequest.getSupplierName());
        }

        if (supplier.process()) {
            System.out.println("\nSupply request placed in " + supplyRequest.getSupplierName() + " has been completed.");
        } else {
            System.out.println("\nYour supply cannot be processed " + supplyRequest.getProductName()
                    + " is unavailable in " + supplyRequest.getSupplierName());
        }
    }
}
