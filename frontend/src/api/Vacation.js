import axios from "axios";

export const vacationInsert = async (params) => {
    try {
        const response = await axios.post('/api/vacation', params);
        return response;
    } catch (error) {
        throw error;
    }
};