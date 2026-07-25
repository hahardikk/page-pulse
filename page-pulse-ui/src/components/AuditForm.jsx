import { use, useState } from "react";
import { auditWebsite } from "../services/auditService";
import AuditResult from "./AuditResult";
import ErrorCard from "./ErrorCard";

const AuditForm = () => {
  const [url, setUrl] = useState("");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const handleAudit = async () => {
    setLoading(true);
    setError("");
    setResult(null);
    
    if (!url.trim()) {
      setError("Please enter a URL.");
      return;
    }

    try {
      setLoading(true);
      setError(null);

      const response = await auditWebsite(url);
      //   console.log("response: ", response);

      setResult(response);
    } catch (err) {
      setError(err.response?.data?.message || "Something went wrong.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="bg-white shadow-2xl rounded-3xl p-7 w-full max-w-xl">
      <h1 className="text-2xl font-bold mb-2">Page Pulse</h1>

      <p className="text-grey-500 mb-6">Audit any website instantly</p>

      <input
        type="text"
        placeholder="https://github.com"
        value={url}
        onChange={(e) => setUrl(e.target.value)}
        className="w-full border rounded-xl px-5 border-gray-300 text-base py-3 outline-none mb-5 focus:ring-blue-200 focus:ring-4 transition"
      />

      <button
        onClick={handleAudit}
        disabled={loading}
        className="bg-linear-to-r mt-2 to-indigo-600 from-blue-600 hover:to-indigo-700 hover:from-blue-700  font-semibold text-white py-3 px-6 shadow-lg rounded-xl duration-300 transition disabled:opacity-50 hover:scale-105 disabled:cursor-not-allowed"
      >
        {loading ? "Auditing..." : "🔍 Analyze Website"}
      </button>

      {error && <ErrorCard message={error} />}

      {result && <AuditResult result={result} />}
    </div>
  );
};

export default AuditForm;
