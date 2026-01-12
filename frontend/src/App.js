import { useEffect, useState } from "react";
import ExpenseForm from "./components/ExpenseForm";
import ExpenseList from "./components/ExpenseList";
import SummaryCard from "./components/SummaryCard";
import { getExpenses, deleteExpense } from "./services/ExpenseService";
import "./App.css";

function App() {
  const [expenses, setExpenses] = useState([]);

  const load = () => getExpenses().then((res) => setExpenses(res.data));

  useEffect(() => {
    load();
  }, []);

  return (
    <div className="container">
      <h2>💰 Expense Tracker</h2>
      <SummaryCard expenses={expenses} />
      <ExpenseForm refresh={load} />
      <ExpenseList
        expenses={expenses}
        refresh={load}
        remove={(id) => deleteExpense(id).then(load)}
      />
    </div>
  );
}

export default App;
