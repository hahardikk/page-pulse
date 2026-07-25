const MetricCard = ({ title, value, bgColor, textColor, suffix = "" }) => {
  return (
    <div className={`${bgColor} rounded-xl p-5 border`}>
      <p className="text-gray-500">{title}</p>

      <h2 className={`text-4xl font-bold ${textColor}`}>
        {value} {suffix}
      </h2>
    </div>
  );
};

export default MetricCard;