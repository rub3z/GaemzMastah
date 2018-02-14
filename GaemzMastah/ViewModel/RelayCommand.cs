

using System;
using System.Windows.Input;

namespace GaemzMastah.ViewModel
{   
    /// <summary>
    /// This is an implementation of ICommand interface
    /// </summary>
    public class RelayCommand : ICommand
    {
        /// <summary>
        /// No need to implemeent this yet since the content of the button won't change
        /// </summary>
        public event EventHandler CanExecuteChanged;
        
        /// <summary>
        /// method that need to run
        /// </summary>
        private Action<object> action;

        /// <summary>
        /// Constructor for ICommand
        /// </summary>
        /// <param name="action"></param>
        public RelayCommand(Action<object> action)
        {
            this.action = action;
        }

        /// <summary>
        /// Check if a command can be executed
        /// </summary>
        /// <param name="parameter">boolean</param>
        /// <returns> boolean </returns>
        public bool CanExecute(object parameter)
        {
            return true;
        }

        /// <summary>
        /// The method that will be executed.
        /// </summary>
        /// <param name="parameter"></param>
        public void Execute(object parameter)
        {
            action(parameter);
        }
    }
}
