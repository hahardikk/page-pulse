const ErrorCard = ({ message }) => {
  return (
    <div className="mt-5 bg-red-100 border border-red-400 rounded-lg p-4">
      <h3 className="font-bold text-red-700">Error</h3>

      <p className="text-red-600">{message}</p>
    </div>
  );
};

export default ErrorCard;