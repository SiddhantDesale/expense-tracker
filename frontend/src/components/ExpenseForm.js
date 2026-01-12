import { useState } from "react";
import { createExpense } from "../services/ExpenseService";

function ExpenseForm({ refresh }) {
  const [form, setForm] = useState({
    title: "",
    amount: "",
    category: "",
    date: "",
  });

  const submit = () => {
    createExpense({ ...form, amount: Number(form.amount) }).then(() => {
      setForm({ title: "", amount: "", category: "", date: "" });
      refresh();
    });
  };

  return (
    <div className="card">
      <h3>Add Expense</h3>
      <input
        placeholder="Title"
        value={form.title}
        onChange={(e) => setForm({ ...form, title: e.target.value })}
      />
      <input
        placeholder="Amount"
        type="number"
        value={form.amount}
        onChange={(e) => setForm({ ...form, amount: e.target.value })}
      />
      <input
        placeholder="Category"
        value={form.category}
        onChange={(e) => setForm({ ...form, category: e.target.value })}
      />
      <input
        type="date"
        value={form.date}
        onChange={(e) => setForm({ ...form, date: e.target.value })}
      />
      <button onClick={submit}>Add Expense</button>
    </div>
  );
}

export default ExpenseForm;
