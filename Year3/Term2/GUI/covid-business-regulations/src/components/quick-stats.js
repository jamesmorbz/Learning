import React from "react";

const QuickStats = () => {
    const stats = [
        { label: 'Total Cases', value: '1.2M' },
        { label: 'Recovered', value: '1.1M' },
        { label: 'Vaccinated', value: '800K' }
    ];
    return (
        <section className="p-4 my-4 bg-white shadow-md rounded">
            <h4 className="font-bold text-lg text-center mb-4">Quick Stats</h4>
            <div className="flex justify-around items-center">
                {stats.map(stat => (
                    <div key={stat.label} className="text-center">
                        <p className="text-gray-600 text-sm">{stat.label}</p>
                        <p className="text-lg font-semibold">{stat.value}</p>
                    </div>
                ))}
            </div>
        </section>
    );
};

export default QuickStats;