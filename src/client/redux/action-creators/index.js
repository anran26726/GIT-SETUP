import axios from "axios";

const getCitiesStart = () => ({ type: "GET_CITIES_START"});
const getCitiesSuccess = ({ payload }) => ({ type: "GET_CITIES_SUCCESS", payload });
const getCitiesError = (error) => ({ type: "GET_CITIES_ERROR", error });

export const getCities = (name) => {
    return (dispatch) => {
        dispatch(getCitiesStart());
        axios.get(`/api/cities/${name}`)
            .then((res) => {
                dispatch(getCitiesSuccess(res.data));
            })
            .catch(err => {
                dispatch(getCitiesError(err))
            });
    };
};
