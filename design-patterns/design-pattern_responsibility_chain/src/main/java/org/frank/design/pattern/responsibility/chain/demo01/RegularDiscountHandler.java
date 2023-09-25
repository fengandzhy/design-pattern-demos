package org.frank.design.pattern.responsibility.chain.demo01;

public class RegularDiscountHandler extends DiscountHandler{
    @Override
    public double applyDiscount(double purchaseAmount) {
        // 如果订单金额在一定范围内，则应用折扣
        if (purchaseAmount <= 100) {
            return purchaseAmount * 0.95; // 5% 折扣
        } else {
            // 无法处理请求，传递给下一个处理器
            if (successor != null) {
                return successor.applyDiscount(purchaseAmount);
            }
            return purchaseAmount;
        }
    }
}