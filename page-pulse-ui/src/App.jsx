import "./App.css";
import AuditForm from "./components/AuditForm";
import Footer from "./components/Footer";

function App() {
  return (
    <div className="min-h-screen bg-linear-to-b from-slate-100 via-blue-50 to-indigo-100 flex flex-col">
      <main className="flex-1 flex items-center justify-center p-8">
        <AuditForm />
      </main>

      <Footer />
    </div>
  );
}

export default App;
