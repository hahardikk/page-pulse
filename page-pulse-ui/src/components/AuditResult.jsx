// import Footer from "./Footer";
import MetricCard from "./MetricCard";

const AuditResult = ({ result }) => {
  return (
    <div className="mt-8 border rounded-lg p-5 transition-all duration-500">
      <div className="grid grid-cols-2 gap-4">
        <MetricCard
          title="Status"
          value={result.status}
          bgColor="bg-green-50"
          textColor="text-green-600"
        />

        <MetricCard
          title="Response Time"
          value={result.responseTime}
          suffix="ms"
          bgColor="bg-blue-50"
          textColor="text-blue-600"
        />

        <MetricCard
          title="H1 Tags"
          value={result.h1Count}
          bgColor="bg-yellow-50"
          textColor="text-yellow-600"
        />

        <MetricCard
          title="Missing ALT"
          value={result.imagesMissingAlt}
          bgColor="bg-red-50"
          textColor="text-red-600"
        />
      </div>

      <div className="mt-8">
        <h2 className="font-bold text-2xl">{result.title}</h2>

        <p className="text-gray-600 mt-3 leading-7">{result.metaDescription}</p>
      </div>

      <div className="mt-6 inline-block bg-gray-100 px-4 py-2 rounded-full">
        📄 {result.wordCount} Words
      </div>

      {/* <footer className="mt-12 text-center text-gray-500 text-sm">
        <a
          href="https://digitalheroesco.com"
          target="_blank"
          rel="noopener noreferrer"
          className="hover:underline"
        >
          Built for Digital Heroes Training Task
        </a>
      </footer> */}
      {/* <Footer /> */}
    </div>
  );
};

export default AuditResult;
