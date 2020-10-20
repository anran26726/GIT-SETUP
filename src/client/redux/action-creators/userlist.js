import axios from "axios";

const getUserlistStart = () => ({ type: "GET_USERLIST_START"});
const getUserlistSuccess = ({ payload }) => ({ type: "GET_USERLIST_SUCCESS", payload });
const getUserlistError = (error) => ({ type: "GET_USERLIST_ERROR", error });

export const getUserlist = (user) => {
    return (dispatch) => {
        dispatch(getUserlistStart());
        axios.get(`/api/userlist/${user}`)
            .then((res) => {
                dispatch(getUserlistSuccess(res.data));
            })
            .catch(err => {
                dispatch(getUserlistError(err))
            });
    };
};
