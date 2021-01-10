import { formatPrice } from "./helpers";

type Props = {
    amout: number;
    totalPrice: number;
    onSubmit: () => void;
}

function OrderSummary( { amout,totalPrice,onSubmit }: Props) {
    return (
        <div className="order-summary-container">
            <div className="order-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">{amout}</strong>
                        PEDIDO SELECIONADOS
                    </span>
                    <span className="order-summary-total">
                        <strong className="amount-selected">{formatPrice(totalPrice)}</strong>
                        VALOR TOTAL
                    </span>
                </div>
                <button className="order-summary-make-order" onClick={onSubmit}>
                    FAZER PEDIDO
                </button>
            </div>
        </div>
    )
}

export default OrderSummary;