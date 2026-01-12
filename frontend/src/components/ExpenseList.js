function ExpenseList({ expenses, refresh, remove }) {
  return (
    <div className="card">
      <h3>Expenses</h3>
      <ul>
        {expenses.map((e) => (
          <li key={e.id}>
            <span>
              {e.title} - ₹{e.amount} ({e.category})
            </span>
            <button onClick={() => remove(e.id)}>✖</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ExpenseList;
