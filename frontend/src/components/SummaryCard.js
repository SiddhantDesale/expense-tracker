function SummaryCard({ expenses }) {
  const total = expenses.reduce((sum, e) => sum + e.amount, 0);

  return (
    <div className="summary">
      <h3>Total Expenses</h3>
      <p>₹ {total}</p>
    </div>
  );
}

export default SummaryCard;
