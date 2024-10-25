public class Payment {

                String customerId;
                String paymentMethod;
                String cvc;
                String cardNumber;
                String expirationDate;
                boolean isPaid;

                public Payment(String customerId, String paymentMethod, String cvc, String cardNumber, String expirationDate, boolean isPaid) {
                    this.customerId = customerId;
                    this.paymentMethod = paymentMethod;
                    this.cvc = cvc;
                    this.cardNumber = cardNumber;
                    this.expirationDate = expirationDate;
                    this.isPaid = isPaid;
                }
            }


