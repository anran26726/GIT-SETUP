import React, { useState } from "react";
import { connect } from "react-redux";

import { getCities } from "../redux/action-creators";

const debounceCreator = () => {
    let ref;

    return (func, timeout, val) => {
        clearTimeout(ref);
        ref = setTimeout(() => func(val), timeout);
    };
};

const getCitiesHelper = debounceCreator();

const App = ({ state: { data }, getCities }) => {
    const [input, setInput] = useState("");

    const handleChange = e => {
        setInput(e.target.value);
        getCitiesHelper(getCities, 400, e.target.value);
    };

    return (
        <div>
            <form onSubmit={e => e.preventDefault()}>
                <input value={input} onChange={handleChange} />
            </form>
            {data && (
                <div>
                    <ul>
                        {data.map((city, index) => {
                            return <li key={index}>{city}</li>
                        })}
                    </ul>
                </div>
            )}
        </div>
    );
};

const mapStateToProps = (state) => {
    return {
        state
    };
};

const mapDispatchToProps = (dispatch) => {
    return {
        getCities: (name) => {
            dispatch(getCities(name));
        }
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(App);
