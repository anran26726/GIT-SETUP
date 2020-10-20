import React from "react";
import { connect } from "react-redux";

import { getUserlist } from "../../redux/action-creators/userlist";
import './userlist.css';

const Userlist = ({ state: { data } }) => {
    return (
        <div>
            {data && (
                <div>
                    <ul>
                        {data.map((user, index) => {
                            return <li key={index}>{user}</li>
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
        getUserlist: (user) => {
            dispatch(getUserlist(user));
        }
    };
};

export default connect(mapStateToProps, mapDispatchToProps)(Userlist);
